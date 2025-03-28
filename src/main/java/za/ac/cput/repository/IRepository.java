package za.ac.cput.repository;

public interface IRepository<Obj, ID> {
    Obj addCustomer(Obj obj);
    Obj read(ID id);
    Obj update(Obj obj);
    boolean delete(ID id);
}
