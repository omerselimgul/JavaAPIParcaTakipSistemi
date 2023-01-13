package parcatakip.parcatakip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parcatakip.parcatakip.business.concretes.BilgisayarParcaManager;
import parcatakip.parcatakip.core.*;
import parcatakip.parcatakip.entities.concretes.BilgisayarParcasiEntity;

@RestController
@RequestMapping("/api/bilgisayar")
public class bilgisayarParcaController {
    BilgisayarParcaManager manager;
    @Autowired
    bilgisayarParcaController(){
        manager=new BilgisayarParcaManager();
    }

    @GetMapping("/getall")
    public DataResult getAll(){
        try{
            return manager.getAll();
        }catch (Exception e){
            return new ErrorDataResult("İşlem sırasında hata olustu : "+e.getMessage());
        }

    }

    @PostMapping("/add")
    public Result Add(@RequestBody BilgisayarParcasiEntity pc)
    {
        try{
            return manager.add(pc);
        }catch (Exception e){
            return new ErrorResult("Kayıt sırasında hata olustu : "+e.getMessage());
        }
    }
    @PutMapping("/edit")
    public Result Edit(@RequestBody BilgisayarParcasiEntity pc)
    {
        try{
            return manager.edit(pc);
        }catch (Exception e){
            return new ErrorResult("Kayıt sırasında hata olustu : "+e.getMessage());
        }
    }
    @PutMapping("/azalt")
    public  Result decreaseStock(@RequestBody BilgisayarParcasiEntity pc){
        try{
            return manager.decreaseStock(pc);
        }catch (Exception e){
            return new ErrorResult("Kayıt sırasında hata olustu : "+e.getMessage());
        }
    }
}
