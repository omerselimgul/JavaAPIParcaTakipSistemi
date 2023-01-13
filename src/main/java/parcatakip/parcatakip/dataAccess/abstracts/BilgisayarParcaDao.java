package parcatakip.parcatakip.dataAccess.abstracts;

import parcatakip.parcatakip.entities.abstracts.Parca;
import parcatakip.parcatakip.entities.concretes.BilgisayarParcasiEntity;

import java.util.ArrayList;

public interface BilgisayarParcaDao {
    public boolean addParca(BilgisayarParcasiEntity bp);
    public ArrayList<Parca> getBilgisayarParcalari();
    public Parca findById(BilgisayarParcasiEntity p);
    public boolean isExistName(String name);
}
