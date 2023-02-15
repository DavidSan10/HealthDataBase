package Node;

public class NodeDouble <T>{
	
	private T data;
	private NodeDouble<T> derecha;
	private NodeDouble<T> izquierda;
	
	
	public NodeDouble(T data) {
		this.data = data;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public NodeDouble<T> getDerecha() {
		return derecha;
	}


	public void setDerecha(NodeDouble<T> derecha) {
		this.derecha = derecha;
	}


	public NodeDouble<T> getIzquierda() {
		return izquierda;
	}


	public void setIzquierda(NodeDouble<T> izquierda) {
		this.izquierda = izquierda;
	}
	

}
