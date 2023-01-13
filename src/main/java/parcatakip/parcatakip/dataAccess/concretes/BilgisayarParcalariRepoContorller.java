package parcatakip.parcatakip.dataAccess.concretes;

import parcatakip.parcatakip.Db;
import parcatakip.parcatakip.dataAccess.abstracts.BilgisayarParcaDao;
import parcatakip.parcatakip.entities.abstracts.Parca;
import parcatakip.parcatakip.entities.concretes.BilgisayarParcasiEntity;

import java.util.ArrayList;

public class BilgisayarParcalariRepoContorller implements BilgisayarParcaDao {

    @Override
    public boolean addParca(BilgisayarParcasiEntity bp) {
        try {
            Db.Parcalar.add(bp);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public ArrayList<Parca> getBilgisayarParcalari() {
        ArrayList<Parca> bilgisayarParcalariList=new ArrayList<>();
        for ( Parca t:Db.Parcalar){
            if(t.getTur()=="Bilgisayar"){
                bilgisayarParcalariList.add(t);
            }
        }
        return bilgisayarParcalariList;
    }

    @Override
    public Parca findById(BilgisayarParcasiEntity p) {

        for(Parca parca: Db.Parcalar){
            BilgisayarParcasiEntity bp= (BilgisayarParcasiEntity) parca;
            if(bp.getParcaId()==p.getUpdateId()){
                return bp;
            }
        }
        return null;
    }
    public void edit(BilgisayarParcasiEntity p,BilgisayarParcasiEntity updateP){


        p.setName(updateP.getName());
        p.setStok(updateP.getStok());
        p.setUnitPrice(updateP.getUnitPrice());

    }
    public boolean decreaseStock(BilgisayarParcasiEntity p,BilgisayarParcasiEntity updateP){
        if(p.getStok()>=updateP.getStok()){
            p.setStok(p.getStok()-updateP.getStok());
            return  true;
        }else{
            return  false;
        }
    }
    @Override
    public boolean isExistName(String name){
        boolean check=false;
        for(Parca parca: Db.Parcalar){
            BilgisayarParcasiEntity bp= (BilgisayarParcasiEntity) parca;
            if(bp.getName().toLowerCase().equals(name.toLowerCase())){
                check= true;
                break;
            }
        }
        return check;
    }

}
