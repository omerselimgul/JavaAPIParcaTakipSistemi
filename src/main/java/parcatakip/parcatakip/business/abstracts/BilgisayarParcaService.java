package parcatakip.parcatakip.business.abstracts;

import parcatakip.parcatakip.core.DataResult;
import parcatakip.parcatakip.core.Result;
import parcatakip.parcatakip.entities.abstracts.Parca;
import parcatakip.parcatakip.entities.concretes.BilgisayarParcasiEntity;

import java.util.List;

public interface BilgisayarParcaService {
    public DataResult<List<Parca>> getAll();
    public Result add(BilgisayarParcasiEntity pa);
    public Result edit(BilgisayarParcasiEntity pc);
}
