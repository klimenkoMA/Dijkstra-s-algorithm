package controller;

import entity.DijkstraAlgoritm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DijkstraAlgoritmService;

import java.util.List;

@Controller
@ComponentScan(basePackageClasses = DijkstraAlgoritmService.class)
public class DijkstraAlgoritmController {

	//	private final int[][] graph = new int[][]{
	//			{0, 4, 0, 0, 0, 0},
	//			{4, 0, 8, 0, 0, 0},
	//			{0, 8, 0, 7, 0, 4},
	//			{0, 0, 7, 0, 9, 14},
	//			{0, 0, 0, 9, 0, 10},
	//			{0, 0, 4, 14, 10, 0}};
	@Autowired
	DijkstraAlgoritmService dijkstraAlgoritmService;

	@GetMapping("/main")
	public String getDijkstraGraph(Model model) {
		List<DijkstraAlgoritm> dijkstraAlgoritmList = dijkstraAlgoritmService.findAllVertex();
		model.addAttribute("dijkstraAlgoritmList", dijkstraAlgoritmList);
		return "dijkstramain";
	}

	@PostMapping("/addvertex")
	public String addNewVertex(@RequestParam int id,
	                           @RequestParam int vertexA,
	                           @RequestParam int vertexB,
	                           @RequestParam int vertexC,
	                           @RequestParam int vertexD,
	                           @RequestParam int vertexE,
	                           @RequestParam int vertexF,
	                           Model model) {
		DijkstraAlgoritm dijkstraAlgoritm = new DijkstraAlgoritm(id, vertexA, vertexB, vertexC,
				vertexD, vertexE, vertexF);

		dijkstraAlgoritmService.addVertex(dijkstraAlgoritm);
		List<DijkstraAlgoritm> dijkstraAlgoritmList = dijkstraAlgoritmService.findAllVertex();
		model.addAttribute("dijkstraAlgoritmList", dijkstraAlgoritmList);
		return "dijkstramain";
	}
}
