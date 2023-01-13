package parcatakip.parcatakip.business.concretes;

import parcatakip.parcatakip.business.abstracts.BilgisayarParcaService;
import parcatakip.parcatakip.core.*;
import parcatakip.parcatakip.dataAccess.concretes.BilgisayarParcalariRepoContorller;
import parcatakip.parcatakip.entities.abstracts.Parca;
import parcatakip.parcatakip.entities.concretes.BilgisayarParcasiEntity;

import java.util.List;

public class BilgisayarParcaManager implements BilgisayarParcaService {
    BilgisayarParcalariRepoContorller bilgisayarRepoContorller;
    public BilgisayarParcaManager(){
        this.bilgisayarRepoContorller=new BilgisayarParcalariRepoContorller();
    }

    @Override
    public DataResult<List<Parca>> getAll() {
        try{
            return new SuccessDataResult<>(bilgisayarRepoContorller.getBilgisayarParcalari());

        }catch (Exception e){
            return new ErrorDataResult<>("Hata olustu : "+e.getMessage());
        }
    }
    @Override
    public Result add(BilgisayarParcasiEntity pa) {
        try{
            if (bilgisayarRepoContorller.isExistName(pa.getName())){
                return new ErrorResult("Bu isimde ürün bulunmaktadır");
            }else{
                if(bilgisayarRepoContorller.addParca(pa)){
                    return new SuccessDataResult<>(bilgisayarRepoContorller.getBilgisayarParcalari(),"Kayıt işlemi başarıyla tamamlandı");
                }
                return new ErrorResult("Ürün eklemede hata oluştu");
            }
        }catch (Exception e){
            return new ErrorResult("Kayıt sırasında hata olustu : "+e.getMessage());
        }
    }
    public Result edit(BilgisayarParcasiEntity pc){
        try{
            BilgisayarParcasiEntity finded= (BilgisayarParcasiEntity) bilgisayarRepoContorller.findById(pc);
            if(finded!=null){
                bilgisayarRepoContorller.edit(finded,pc);
                return new SuccessDataResult(bilgisayarRepoContorller.getBilgisayarParcalari(),"İşlem başarıyla tamamlandı");
            }else{
                return new ErrorResult("Bu id de data bulunumadı");
            }
        }catch (Exception e){
            return new ErrorResult("edit sırasında hata olustu : "+e.getMessage());
        }
    }

    public Result decreaseStock(BilgisayarParcasiEntity pc){
        try{
            BilgisayarParcasiEntity finded= (BilgisayarParcasiEntity) bilgisayarRepoContorller.findById(pc);
            if(finded!=null){
                bilgisayarRepoContorller.decreaseStock(finded,pc);
                return new SuccessDataResult(bilgisayarRepoContorller.getBilgisayarParcalari(),"İşlem başarıyla tamamlandı");
            }else{
                return new ErrorResult("Bu id de data bulunumadı");
            }
        }catch (Exception e){
            return new ErrorResult("edit sırasında hata olustu : "+e.getMessage());
        }
    }

}
