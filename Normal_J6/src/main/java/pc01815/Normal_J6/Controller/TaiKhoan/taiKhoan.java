package pc01815.Normal_J6.Controller.TaiKhoan;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Services.AccountsService;

@Controller
public class taiKhoan {
	@Autowired
	AccountsService accountService;
    @RequestMapping("/login")
    public String login() {
//    	BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
//    	Accounts user = accountService.findByUsernameService("admin");
//    	String pass = pe.encode(user.getPassword());
//		
//    	System.out.println("username: "+user.getUsername());
//    	System.out.println("pass: "+pass);
    	return "TaiKhoan/login";
    }
}