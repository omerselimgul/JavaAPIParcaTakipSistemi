package parcatakip.parcatakip.entities.concretes;

import parcatakip.parcatakip.entities.abstracts.Parca;
import parcatakip.parcatakip.entities.abstracts.ParcaAbs;

public class BilgisayarParcasiEntity extends ParcaAbs implements Parca  {
    private static int  id=1;
    private int ParcaId;


    public BilgisayarParcasiEntity(){
        this.ParcaId=id++;
    }
    protected int updateId;

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
        id=id-1;
    }


    private String tur="Bilgisayar";
    public int getParcaId(){
        return ParcaId;
    }
    public void setParcaId(int parcaId){
        this.ParcaId=parcaId;
    }
    public String getTur() {
        return this.tur;
    }

}
