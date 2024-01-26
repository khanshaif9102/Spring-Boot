package com.shaif.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaif.springmvc.Repository.AlienDao;
import com.shaif.springmvc.model.Alien;

@Controller
public class HomeController
{
	@Autowired
	private AlienDao dao;
	
	
	//firstly called before any mapping 
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name","Aliens");
	}
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
//	@RequestMapping("add")
//	public String add(@RequestParam("num1")int i,@RequestParam("num2")int j,Model m) 
//	{
//		//ModelAndView mv=new ModelAndView("result");
//		
//		int sum=i+j;
//	    m.addAttribute("sum",sum);
//		return "result";
//	}
//	@RequestMapping("addAlien")
//	@RequestMapping(value="addAlien",method=RequestMethod.POST)
//	@GetMapping(value="addAlien")
	
//	@PostMapping(value="addAlien")
//	//public String addAlien(@RequestParam("aid") int aid,@RequestParam("aname") String aname,Model m) 
//	public String addAlien(@ModelAttribute("a1") Alien a) 
//	{
//		return "result";
//	}
//	@GetMapping("getAliens")
//	public String getAliens(Model m)
//	{
//		List<Alien> aliens=Arrays.asList(new Alien(101,"shaif"),new Alien(102,"albab"));
//		m.addAttribute("result",aliens);
//		return "showAliens";
//	}
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		m.addAttribute("result",dao.getAliens());
		return "showAlien";
	}
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute Alien a)
	{
		
		return "result";
	}
}
