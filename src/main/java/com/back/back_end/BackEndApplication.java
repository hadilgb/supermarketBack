package com.back.back_end;

import com.back.back_end.model.Product;
import com.back.back_end.model.category;
import com.back.back_end.model.subcategory;
import com.back.back_end.repository.ProductRepository;
import com.back.back_end.repository.categoryRepository;
import com.back.back_end.repository.subcategoryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
@EnableMongoRepositories
public class BackEndApplication implements CommandLineRunner{
	
	@Autowired
	categoryRepository categoryRepos ;

	@Autowired
	ProductRepository prodrepo;
	@Autowired
	subcategoryrepository subrepo;
	
	//CREATE

public void run(String... args) {
	subrepo.save(new subcategory("","","hello","gg",null));
	/*category c = new category();
	Set <category> s = new HashSet<category>();
	categoryRepos.save(new category("","./assets/img/categories/grocery.jpg","Grocery","vv",s,c));*/
	/*	Product p = new Product("","tfyguhioip","64884ebb4cfa03736f8e08f1","milk", 10L,20.00,"hg",56,8);
			prodrepo.save(p);*/

	/*categoryRepos.save(new category("./assets/img/categories/electronics.jpg","Electronics",sub));
	categoryRepos.save(new category("./assets/img/categories/home.jpg","Home",sub));
	categoryRepos.save(new category("./assets/img/categories/toys.jpg","Toys",sub));
	categoryRepos.save(new category("./assets/img/categories/outdoor_living.jpg","Outdoor living",sub));
	categoryRepos.save(new category("./assets/img/categories/baby.jpg","Baby",sub));
	categoryRepos.save(new category("./assets/img/categories/personal_care.jpg","Personal care",sub));
	categoryRepos.save(new category("./assets/img/categories/health.jpg","Health",sub));
	categoryRepos.save(new category("./assets/img/categories/pets.jpg","Pets",sub));
	categoryRepos.save(new category("./assets/img/categories/beauty.jpg","Beauty",sub));
	categoryRepos.save(new category("./assets/img/categories/allclothes.jpg","All clothing,Shoes & accessories",sub));
	categoryRepos.save(new category("./assets/img/categories/women.jpg","Women's clothing",sub));
	categoryRepos.save(new category("./assets/img/categories/baby_clothes.jpg","Kids & Baby clothing",sub));
	categoryRepos.save(new category("./assets/img/categories/men.jpg","Men's clothing"));
	categoryRepos.save(new category("./assets/img/categories/appliances.jpg","Appliances"));
	categoryRepos.save(new category("./assets/img/categories/furniture.jpg","Furniture"));
	categoryRepos.save(new category("./assets/img/categories/sport.jpg","Sport & rec"));
	categoryRepos.save(new category("./assets/img/categories/video_game.jpg","Video games"));
	categoryRepos.save(new category("./assets/img/categories/pantry.jpg","Pantry & household"));
	categoryRepos.save(new category("./assets/img/categories/watch.jpg","Jewellery & watches"));
	categoryRepos.save(new category("./assets/img/categories/automotive.jpg","Automotive"));
	categoryRepos.save(new category("./assets/img/categories/gift.jpg","Gifts & holidays"));
	categoryRepos.save(new category("./assets/img/categories/cahier.jpg","Office,crafts & party supplies"));
	categoryRepos.save(new category("./assets/img/categories/gift_card.jpg","Gift cards"));
		for (Product prod: productRepo.findAll()) {
			System.out.println(prod);
		}
		for (User u:userRepository.findAll()){
			System.out.println(u);

		}*/

		
						
	}
	public static void main(String args[]){
		SpringApplication.run(BackEndApplication.class,args);
	}
 

}
