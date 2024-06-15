
package CMPT276.Assignment2.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import CMPT276.Assignment2.models.Rectangle;
import CMPT276.Assignment2.models.RectangleRepository;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class RectangleController {

    @Autowired
    private RectangleRepository rectangleRepository;

    @GetMapping("/rectangles/showAll")
    public String getAllRectangles(Model model) {
        System.out.println("getting ALl rectangles");
        List<Rectangle> rectangles = rectangleRepository.findAll();
        model.addAttribute("rectangles", rectangles);
        return "users/rectangleList";
    }

   

    @PostMapping("/rectangles/add")
    public String addRectangle(@RequestParam Map<String, String> newRectangle, HttpServletResponse response) {
        System.out.println("adding user LALALALALA");
        String name = newRectangle.get("name");
        int width = Integer.parseInt(newRectangle.get("width"));
        int height = Integer.parseInt(newRectangle.get("height"));
        String color = newRectangle.get("color");
        Rectangle Rectangle = new Rectangle(name,width,height,color);
        
        rectangleRepository.save(Rectangle);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return "redirect:/rectangles/showAll";
    }

  
    @PostMapping("/rectangles/delete")
    public String deleteRectangle(@RequestParam("id") int id){
        System.out.println("delete called");
        if(rectangleRepository.existsById(id)){
            System.out.println("delete succesful");
            rectangleRepository.deleteById(id);
            return "redirect:/rectangles/showAll";
        }else{
            return "redirect:/rectangles/showAll";
        }
    }

    @GetMapping("/rectangles/select")
    public String selectRectangle(@RequestParam("id") int id, Model model){
        Rectangle rectangle = rectangleRepository.findById(id).orElse(null);
        if(rectangle != null){
            model.addAttribute("rectangle",rectangle);
            return "users/selectRectangle";
        }else{
            return "redirect:/rectangles/showAll";
        }
    }

    @PostMapping("/rectangles/update")
    public String updateRectangle(@ModelAttribute Rectangle rectangle){

        System.out.println("In update");
        rectangleRepository.save(rectangle);
        return "redirect:/rectangles/showAll";
    }



    @GetMapping("/addPage")
    public String redirectAddPage(){
        return "redirect:/add";
    }
   
}