package cn.hncu.service;

import cn.hncu.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Date;


public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ManagerService managerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerService.findByUsername(username);
        //更新登录时间
        manager.setLoginTime(new Date());
        managerService.update(manager);
        if (manager == null)
            return null;
        else {
            ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(manager.getUsername(), manager.getPassword(), grantedAuthorities);
        }
    }
}
