package member;

import java.util.List;

public interface GenericInterface<T> {
	// MemberVo member = (MemberVo)obj;
//	public List<Object> search(String name);
	public List<T> search(String name);
	public T search(int id);
	public int delete(int id);
	public int update(T entity);	
	public List<T> listAll();
	public int insert(T entity);
}
