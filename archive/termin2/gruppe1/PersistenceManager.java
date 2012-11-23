public interface PersistenceManager<T> {
  T load();
  void store(T t);
}
