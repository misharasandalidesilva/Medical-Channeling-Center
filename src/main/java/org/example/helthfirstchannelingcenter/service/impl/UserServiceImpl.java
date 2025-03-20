package org.example.helthfirstchannelingcenter.service.impl;


import org.example.helthfirstchannelingcenter.dto.UserDTO;
import org.example.helthfirstchannelingcenter.entity.User;
import org.example.helthfirstchannelingcenter.repo.UserRepository;
import org.example.helthfirstchannelingcenter.service.UserService;
import org.example.helthfirstchannelingcenter.utill.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public int saveUser(UserDTO userDTO) {

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//            userDTO.setRole("USER");
            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;

        }

    }

    @Override
  /*  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user = userRepository.findByEmail(username);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), getAuthority(user)
        );
    }*/
    public UserDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return modelMapper.map(user, UserDTO.class);
    }


    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }
}
