package BinaryTree;

import java.util.ArrayList;
import java.util.Comparator;

import Node.NodeDouble;

public class BinaryTree<T> {
	
	private NodeDouble<T> root;
//	private Comparator<T> comparator;
	private ArrayList<NodeDouble<T>> list;
	private int count;
	
	public BinaryTree() {
	}

	
//	public void createBinaryTree( Comparator<T> comparator) {
//		root = null;
//	
//		this.comparator = comparator;
//	}
//	
	
	/*
	 * En el metodo insert ingresa un dato donde si arbol esta vacio
	 * ese dato va a ser la raiz, de lo contrario llama al metodo recursivo addValue
	 * */
	
	public void insert(T data,Comparator<T> comparator) {
		if(root == null) {
			root = new NodeDouble<T>(data);
		}else {
			addValue(data,root,comparator);
		}
	}
	
	/*
	 * AddValue(data,node) recibo el dato a ingresa y un nodo donde en 
	 * la primera iteraccion es la raiz, por medio del comparator observa que si el valor 
	 * ingresado es menor al dato que se esta comparando en la primera iteraccion la raiz, se va 
	 * al lado izquierdo y si no se va al lado derecho,posteriormente pregunta que se la ramificacion
	 * por la que se fue es nulay si lo es agrega en ese lugar el valor de lo contrario, accede al nodo 
	 * izquierdo o derecho dependiendo a donde se fue y ese valor ahora es el que vuelve a evaluar hasta
		encontrar donde ubicarse
	 * */
	
	private void addValue(T data,NodeDouble<T> node,Comparator<T> comparator) {
		if(comparator.compare(node.getData(),data) > 0) {
			if(node.getIzquierda() == null) {
				node.setIzquierda(new NodeDouble<T>(data));
			}else {
				addValue(data,node.getIzquierda(),comparator);
			}
		}else {
			if(comparator.compare(node.getData(),data) < 0) {
				if(node.getDerecha() == null) {
					node.setDerecha(new NodeDouble<T>(data));
				}else {
					addValue(data,node.getDerecha(),comparator);
				}
			}
		}	
	}
	
	
	public boolean isEmpty() {
		return root == null ? true:false;
	}
	
	
	public boolean isExist(T data,Comparator<T> comparator) {
		return isExitsAux(data,root,comparator);
	}
	
	
	private boolean isExitsAux(T data,NodeDouble<T> aux,Comparator<T> comparator) {
		if(aux == null) {
			return false;
		}else if(comparator.compare(aux.getData(), data) == 0) {
			return true;
		}else if(comparator.compare(aux.getData(), data) > 0) {
			return isExitsAux(data,aux.getIzquierda(),comparator);
		}else {
			return isExitsAux(data,aux.getDerecha(),comparator);
		}	
	}
	
	
	public T isExistData(T data,Comparator<T> comparator) {
		return isExitsAuxData(data,root,comparator);
	}
	
	
	private T isExitsAuxData(T data,NodeDouble<T> aux,Comparator<T> comparator) {
		if(aux == null) {
			return null;
		}else if(comparator.compare(aux.getData(), data) == 0) {
			return aux.getData();
		}else if(comparator.compare(aux.getData(), data) > 0) {
			return isExitsAuxData(data,aux.getIzquierda(),comparator);
		}else {
			return isExitsAuxData(data,aux.getDerecha(),comparator);
		}	
	}
	
	
	
	
	
	public int getSize() {
		count = 0;
		preOrder();
		return count;
	}
	
	
	public void preOrder() {
	
		preOrder(root);
	}
	
	private void preOrder(NodeDouble<T> aux) {
		if(aux != null) {
			count++;
			preOrder(aux.getIzquierda());
			preOrder(aux.getDerecha());
			
		}
		
	}
	
	
	public void intOrder() {
		intOrder(root);
	}
	
	
	private void intOrder(NodeDouble<T> aux) {
		if(aux != null) {
			intOrder(aux.getIzquierda());
			System.out.println(aux.getData());
			intOrder(aux.getDerecha());
			
		}
		
	}
	
	public void postOrder() {
		list = new ArrayList<NodeDouble<T>>();
		postOrder(root);
	}
	
	
	private void postOrder(NodeDouble<T> aux) {
		if(aux != null) {
			postOrder(aux.getIzquierda());
			list.add(aux);
			postOrder(aux.getDerecha());	
		}
		
	}
	
	
	public ArrayList<NodeDouble<T>> getListTree() {
		postOrder();
		return list;
	}
	
	public synchronized ArrayList<T> getListData(){
		ArrayList<T> list = new ArrayList<T>();
		ArrayList<NodeDouble<T>> listNode = getListTree();
		for (int i = 0; i < listNode.size(); i++) {
			//System.out.println("valor get listNode::::::" + listNode.get(i).getData());
			list.add(listNode.get(i).getData());
		}
		return list;
	}

	public void remove(T data,Comparator<T> comparator) {
		remove(data,root,null,comparator);
	}
	
	private void remove(T data,NodeDouble<T> hijo,NodeDouble<T> padre,Comparator<T> comparator) {
		count = 0;
		if(hijo == null) {
			return;
		}else if(comparator.compare(hijo.getData(), data) > 0) {
			remove(data,hijo.getIzquierda(),hijo,comparator);
		}else if(comparator.compare(hijo.getData(), data) < 0) {
			remove(data,hijo.getDerecha(),hijo,comparator);
		}else {
			if(comparator.compare(hijo.getData(), data) ==  0) {
				if(getTheNumberOfChild(hijo) == 1) {
					if(padre == null) {
						if(hijo.getIzquierda() != null) {
							hijo = hijo.getIzquierda();
							root = hijo;
						}else {
							hijo = hijo.getDerecha();
							root = hijo;
						}
					}else {
						if(comparator.compare(padre.getData(), hijo.getData()) > 0) {
							padre.setIzquierda(getSubTree(hijo));
						}else {
							padre.setDerecha(getSubTree(hijo));
						}	
					}
					
				}else if(getTheNumberOfChild(hijo) == 2){
					hijo.setData(getLeftSubTreeTwo(hijo.getIzquierda(),hijo));
					
				}else if(hijo == root && getTheNumberOfChild(hijo) == 0) {
					root = null;
				}else{
					if(comparator.compare(padre.getData(), hijo.getData()) > 0) {
						padre.setIzquierda(null);
					}else {
						padre.setDerecha(null);
					}
				}
			}
		}
	}
	
	
	public int getTheNumberOfChild(NodeDouble<T> aux) {
		int count = 0;
		if(aux.getDerecha() != null) {
			count++;
		}
		if(aux.getIzquierda() != null) {
			count++;
		}
		return count;
	}
	
	public NodeDouble<T> getSubTree(NodeDouble<T> aux){
		return aux.getIzquierda() != null ? aux.getIzquierda():aux.getDerecha();
	}
		
	
	public T getLeftSubTreeTwo(NodeDouble<T> hijo,NodeDouble<T> padre) {
		if(hijo.getDerecha() == null) {
			if(hijo.getIzquierda() != null) {
				if(count == 0) {
					padre.setIzquierda(hijo.getIzquierda());
					return hijo.getData();
				}else {
					padre.setDerecha(hijo.getIzquierda());
					return hijo.getData();
				}
			}else if(count == 0) {
				padre.setIzquierda(null);
				return hijo.getData();
			}else {
				padre.setDerecha(null);
				return hijo.getData();
			}
		
		}else {
			count++;
			return getLeftSubTreeTwo(hijo.getDerecha(),hijo);
		}
		
	}
	

	
	
	public boolean isInternal(NodeDouble<T> node) {
		return (node.getDerecha() != null || node.getIzquierda() != null) ? true:false;
	}
	
	public int getHeightTree() {
		return getHeight(root);
	}
	
	private int getHeight(NodeDouble<T> node) {
	int height = 0;
		if(isInternal(node)) {
			if(node.getIzquierda() != null) {
				height = Math.max(height, getHeight(node.getIzquierda()));
			}
			
			if(node.getDerecha() != null) {
				height = Math.max(height, getHeight(node.getDerecha()));
			}
			height++;
		}
		return height;
	}
	
	
	
}
