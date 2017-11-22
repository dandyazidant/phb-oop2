package srtmsk.surat_masuk.controller;

import srtmsk.surat_masuk.repo.SrtmasukRepo;
import srtmsk.surat_masuk.entity.Suratmasuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

@Controller
public class WebController {
    
    @Autowired
    private SrtmasukRepo srtRepo;
	
    @RequestMapping("/daftar-suratmasuk")
    public void daftarSuratmasuk(Model model) {
        model.addAttribute("daftarSuratmasuk", 
                srtRepo.findAll());
    }

    @RequestMapping("/tambah-surat")
    public void tambahSurat(
    	@ModelAttribute("srt") Suratmasuk srt,
    	BindingResult result) {}

    @RequestMapping(value = "/tambah-surat",
    	method = RequestMethod.POST) 
    public String simpanSurat(
    		@ModelAttribute("srt") Suratmasuk srt,
    		BindingResult result) {
    	System.out.println(srt.getId());
    	srtRepo.save(srt);

    	return "redirect:/daftar-suratmasuk";
    }

    @RequestMapping("/edit")
    public void getEditForm(
    		@RequestParam("id") String id, 
    		Model model) {
    	Suratmasuk result = srtRepo.findOne(id);
    	model.addAttribute("srt", result);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String simpanEditData(
    		@ModelAttribute("srt") Suratmasuk srt,
    		BindingResult result) {
    	System.out.println("id : " + srt.getId());
    	srtRepo.save(srt);
    	return "redirect:/daftar-suratmasuk";
    }
    
    @RequestMapping("/hapus")
    public String hapusData(@RequestParam("id") String id) {
        srtRepo.delete(id);
        return "redirect:/daftar-suratmasuk";
    }
    
}
