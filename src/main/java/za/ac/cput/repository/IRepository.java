package za.ac.cput.repository;

public interface IRepository<Obj, ID> {
    Obj add(Obj obj);
    Obj read(ID id);
    Obj update(Obj obj);
    boolean delete(ID id);
}
