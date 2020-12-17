package com.spring.webApps.WepAppsProject.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.webApps.WepAppsProject.security.User;



public class UserPrincipal implements UserDetails  {

	private static final long serialVersionUID = 1L;
	private User user  ; 

	
	
	public UserPrincipal(User user ) { 
		this.user = user ; 
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//list of permissions 
		List<GrantedAuthority> authorities = new ArrayList<>(); 
		
		
		this.user.convertPermissionsToList().forEach(p-> {
			GrantedAuthority authority = new SimpleGrantedAuthority(p) ; 
			authorities.add(authority);
		});
		
		//list of roles 
		this.user.convertRolesToList().forEach(r-> {
			GrantedAuthority authority = new SimpleGrantedAuthority(r) ; 
			authorities.add(authority);
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.isActive() == true ;
	}

}
