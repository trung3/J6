package pc01815.Normal_J6.Services;



import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;
import pc01815.Normal_J6.Entity.Roles;
import pc01815.Normal_J6.Repository.AccountsRepository;
import pc01815.Normal_J6.Repository.AuthoritiesRepository;
import pc01815.Normal_J6.Repository.RolesRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountsService{

	@Autowired
	AccountsRepository accountsRepository;
	
	@Autowired
	AuthoritiesRepository authRepo;
	
	@Autowired
	RolesRepository roleRepo;

	@Override
	public List<Accounts> getAllService() {
		List<Accounts> listAccount = accountsRepository.findAll();
		return listAccount;
	}

	@Override
	public Accounts saveAccountService(Accounts accounts) {
		
		return accountsRepository.save(accounts);
	}

	@Override
	public Accounts findByUsernameService(String username) {
		return accountsRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Accounts account = accountsRepository.findByUsername(username);
			String pass = account.getPassword();
//			Set<Authorities> roles = account.getAuthoritieses();
//			System.out.println("------------------------------------");
//			for (Authorities authorities : roles) {
//				
//				System.out.println(authorities.getRoles());
//			}
//			System.out.println("------------------------------------");
			String[] roles = account.getAuthoritieses().stream()
					.map(au ->au.getRoles().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
		
			return User.withUsername(username).password(pass).roles(roles).build();
		} catch (Exception e) {
			throw new UsernameNotFoundException(username+"not found!!");
		}
	}
	


	
	
	
}
