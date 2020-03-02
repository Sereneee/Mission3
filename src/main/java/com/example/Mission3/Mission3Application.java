package com.example.Mission3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mission3Application {

	public static void main(String[] args)
	{
//		String url = "jdbc";
//		String user = "";
//		String pwd = "";
//		try {
//			Connection myConn = DriverManager.getConnection(url, user, pwd);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		/*try{
			SpringApplication.run(Mission3Application.class, args);
		} catch (Exception e){
			e.printStackTrace();
		}*/

		SpringApplication.run(Mission3Application.class, args);


	}
//	@Bean
//	ApplicationRunner applicationRunner(PetRepository petRepository){
//		return args -> {
//			Pet pet1 = Pet.create( "benji",  1,  "dog");
//			Pet pet2 = Pet.create( "jackie",  12,  "dog");
//
//			System.out.println("Helloooooooooooooooooooooooooooooooooooooooooooooo" + petRepository.save(pet1));
//			System.out.println("Helloooooooooooooooooooooooooooooooooooooooooooooo" + petRepository.save(pet2));
//
//			System.out.println(petRepository.findByName("benji"));
//		};
//	}
}
