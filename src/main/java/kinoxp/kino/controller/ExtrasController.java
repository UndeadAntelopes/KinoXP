package kinoxp.kino.controller;

import kinoxp.kino.model.Extras;
import kinoxp.kino.service.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExtrasController {
        
        @Autowired
        ExtrasService extrasService;
        
        //show update movie form
        @GetMapping("/updateExtras/{id}")
        public String updateExtras(@PathVariable("id") int id, Model model){
            model.addAttribute("extras",extrasService.findExtrasById(id));
            return "updateExtras";
        }
        
        //update movie information
        @PostMapping("/updateExtras/{id}")
        public String updateExtras(@ModelAttribute Extras extras, @PathVariable("id") int id){
            extras.setId(id);
            extrasService.updateExtras(extras);
            return "redirect:/extrasList"; 
        }
        
        @GetMapping("/deleteExtras/{id}")
        public String deleteExtras(@PathVariable("id") int id, Model model) {
            extrasService.deleteExtras(id);
            return "redirect:/extrasList";
        }
        
        
        @GetMapping ("/addExtras")
        public String add() {
            return "addExtras";
        }
        
        @PostMapping ("/addExtras")
        public String add(@ModelAttribute Extras extras) {
            extrasService.addExtras(extras);
            return "redirect:/extrasList";
        }
        
        @GetMapping ("/extrasList")
        public String fetchAll(Model model){ 
            model.addAttribute("extras",extrasService.fetchAll());
            return "extrasList";
        }
        
        
        
}
