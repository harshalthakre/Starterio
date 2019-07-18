package com.project.starterio_version_1.services;

import com.project.starterio_version_1.model.Privilege;
import com.project.starterio_version_1.model.Role;
import com.project.starterio_version_1.model.User;
import com.project.starterio_version_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    long sessionId;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=userRepository.findByUsername(username);
        System.out.println("user is: "+user);
        if(user==null){throw new UsernameNotFoundException("Invalid Username or Password");}
        if(user.getRoles()==null||user.getRoles().isEmpty()){
            throw new UsernameNotFoundException("User not Authorized");
        }
        sessionId=user.getId();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),getAuthority(user.getRoles()));
    }

    private List<? extends GrantedAuthority> getAuthority(Set<Role> roles){
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Set<Role> roles){
        List<String> privileges=new ArrayList<String>();
        List<Privilege> collection=new ArrayList<Privilege>();

        for(Role role:roles){
            collection.addAll(role.getPrivileges());
        }
        for(Privilege item:collection){
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges){
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        for(String privilege:privileges){
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        authorities.add(new SimpleGrantedAuthority("user"+sessionId));
        return authorities;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUser(int userId){
        return userRepository.findById(userId);
    }

    public boolean updateUser(int userId,User user){
        if(userRepository.findById(userId)!=null){
            userRepository.save(user);
            return true;
        }
        else return false;
    }
}
