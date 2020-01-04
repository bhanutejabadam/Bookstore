package com.example.demo;

import java.util.Optional;

import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class Bookstorecontroller {
	Book book;
	
	@Autowired
	private BookstoreDao dao;
	
	@RequestMapping({"/home","/"})
	public String home() {
		return "home";
	}
	
	@RequestMapping("/save")
	public String save() {
		return "save";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "search";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@RequestParam int id,@RequestParam String name,@RequestParam int price) {
		book=new Book();
		book.setId(id);
		book.setName(name);
		book.setPrice(price);
		dao.insert(book);
		return "home";
	}
	@RequestMapping(value="show")
	@ResponseBody
	public  Iterable<Book> show(){
		return dao.show();
	}
	@RequestMapping("find")
	@ResponseBody
	public Optional<Book> search(@RequestParam int id) {
	
		return dao.search(id);
	}
}
