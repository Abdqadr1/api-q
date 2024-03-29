package com.qadr.bankapi.controller;

import com.qadr.bankapi.model.Bank;
import com.qadr.bankapi.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired private BankService bankService;

    @GetMapping("/all")
    public List<Bank> getAll(){
        return bankService.getAllBanks();
    }

    @GetMapping("/alias/{alias}")
    public Bank getBankByAlias(@PathVariable("alias") String alias){
        return bankService.getBankByAlias(alias);
    }

    @GetMapping("/id/{id}")
    public Bank getBankById(@PathVariable("id") Integer id){
        return bankService.getBankById(id);
    }


    @GetMapping("/type/{type}")
    public List<Bank> getBanksByType(@PathVariable("type") String type){
        return bankService.getBanksByType(type);
    }


    @PostMapping("/admin/add")
    public Bank addBank(@RequestBody Bank bank){
        System.out.println(bank);
        return bankService.addBank(bank);
    }

    @GetMapping("/admin/enabled/{id}/{enabled}")
    public void updateEnabled(@PathVariable("id") Integer id,
                              @PathVariable("enabled") boolean enabled){
        bankService.updateEnabled(id,enabled);
    }


    @GetMapping("/admin/page/{number}")
    public Map<String, Object> getBankPage(@PathVariable("number") Integer pageNumber,
                                           @RequestParam(value = "keyword", defaultValue = "") String keyword){
        return bankService.getBankPage(pageNumber, keyword);
    }


    @DeleteMapping("/admin/delete/{id}")
    public Bank deleteBank(@PathVariable("id") int id){
        return bankService.deleteBankById(id);
    }

    @PostMapping("/admin/edit")
    public Bank editBank (Bank bank){
        return bankService.updateBank(bank);
    }

}



