package za.ac.cput.repository;
/*
Author: Thabiso Mbatha (221563423)
 */

public interface IRepository<Obj, ID> {
    Obj add(Obj obj);
    Obj read(ID id);
    Obj update(Obj obj);
    boolean delete(ID id);
}
