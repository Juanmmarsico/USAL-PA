package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ClaseRandom {
ArrayList<Integer> noseque;
ArrayList<Camion> camion;

public ClaseRandom() {
	// TODO Auto-generated constructor stub
	noseque = new ArrayList<Integer>();
	camion = new ArrayList<Camion>();
}

public ClaseRandom(ArrayList<Integer> noseque, ArrayList<Camion> camion) {
	this.noseque = noseque;
	this.camion = camion;
}
public ClaseRandom (int capacidad){
	camion = new ArrayList<Camion>();
	noseque=  new ArrayList<Integer>(capacidad);
	for(int i=0;i<capacidad;i++){
		noseque.add((new Random()).nextInt(899)+100);
	}
}
public ClaseRandom(int capacidad,ArrayList<Camion> camiones){
	this(capacidad);
	camion = camiones;
}
public ClaseRandom(int capacidad,List<Camion> camiones){
	this(capacidad);
	for (Camion cam : camiones) {
		camion.add(cam);
	}
}
public ClaseRandom(int capacidad,Camion [] camiones){
	this(capacidad);
	for (Camion cam : camiones) {
		camion.add(cam);
	}
}

public Camion removerCamion(Camion cam) throws ExcepcionPropia{
	try {
		return camion.remove(camion.indexOf(cam));
	} catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
		throw new ExcepcionPropia(1);
	}
}
public int removerInteger(int cam) throws ExcepcionPropia{
	try {
		return noseque.remove(noseque.indexOf(cam));
	} catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
		throw new ExcepcionPropia(0);
	}
}


public int maximoValor(){
	return Collections.max(noseque);
}
public ArrayList<Camion> ordenDecendente(){
	ArrayList<Camion> aux = new ArrayList<Camion>(camion);
	Comparator<Camion>c = new Comparator<Camion>() {
		@Override
		public int compare(Camion o1, Camion o2) {
			// TODO Auto-generated method stub
			return o1.getFechaPatentamiento().compareTo(o2.getFechaPatentamiento());
		}
	};
	aux.sort(c);
	return aux;
}
public boolean hayRepetidos(){
	ArrayList<Camion> c = new ArrayList<Camion>(camion);
	for (Camion cam : camion) {
		c.remove(c.indexOf(cam));
		if(c.contains(cam)){
			return true;
		}
	}
return false;
}

public ArrayList<Integer> busquedaMultiple(int numeroPasado) throws ExcepcionPropia{
ArrayList<Integer> aux =new ArrayList<Integer>(noseque);
ArrayList<Integer> devolver =new ArrayList<Integer>();
	while (aux.contains(numeroPasado)) {
		devolver.add(aux.indexOf(numeroPasado));
		aux.remove(aux.indexOf(numeroPasado));
	}
	if (devolver.isEmpty()) {
		throw new ExcepcionPropia(0);
	}
	return devolver;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public ArrayList<Integer> igualesValores(ArrayList numerosPasados) throws ExcepcionPropia{
	ArrayList<Integer> c= new ArrayList<>(noseque);
	ArrayList<Camion> cam= new ArrayList<Camion>(camion);

	ArrayList<Integer> integArray= new ArrayList<Integer>();;
	ArrayList<Camion> camionArray= new ArrayList<Camion>();;
	Iterator b= numerosPasados.iterator();
	while (b.hasNext()) {
		Object object = (Object) b.next();
		if (object instanceof Integer) {
			integArray = numerosPasados;
			break;
		}
		if (object instanceof Camion) {
			camionArray = numerosPasados;
			break;
		}
	}
	if (integArray.isEmpty() && !camionArray.isEmpty()) {
		Comparator <Camion> comparator = new Comparator<Camion>() {
			@Override
			public int compare(Camion o1, Camion o2) {
				// TODO Auto-generated method stub
				return o1.getFechaPatentamiento().compareTo(o2.getFechaPatentamiento());
			}
		};
		cam.sort(comparator);
		ArrayList<Integer> d= new ArrayList<Integer>();
		for (Camion camionn : cam) {
			 while (integArray.contains(camionn)){
				 d.add(integArray.remove(integArray.indexOf(camionn)));
			 }
		}
		return d;
	
	}else{
		if(!integArray.isEmpty() && camionArray.isEmpty()){
			Comparator <Integer> comparator = new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1-o2;
				}
			};
			c.sort(comparator);
			ArrayList<Integer> d= new ArrayList<Integer>();
			for (Integer integer : c) {
				 while (integArray.contains(integer)){
					 d.add(integArray.remove(integArray.indexOf(integer)));
				 }
			}
			return d;
		}
	}
	throw new ExcepcionPropia(2);
	
}

public ArrayList<Integer> getNoseque() {
	return noseque;
}

public ArrayList<Camion> getCamion() {
	return camion;
}

public void setNoseque(ArrayList<Integer> noseque) {
	this.noseque = noseque;
}

public void setCamion(ArrayList<Camion> camion) {
	this.camion = camion;
}

}
