package dominio;

public interface IVenda {
	//@ public model instance int codVenda;
	//@ public model instance String CPF;
	//@ public model instance String data;
	//@ public model instance String hora;
	
	//@ ensures 0 <= \result;
	public /*@ pure @*/ int getCodVenda();
	
	public void setCodVenda(int codVenda);
	
	//@ ensures !\result.equals(null);
	public /*@ pure @*/ String getCPF();
	
	public void setCPF(String CPF);
	
	//@ ensures !\result.equals(null);
	public /*@ pure @*/ String getData();
	
	public void setData(String data);
	
	//@ ensures !\result.equals(null);
	public /*@ pure @*/ String getHora();
	
	public void setHora(String hora);
}
