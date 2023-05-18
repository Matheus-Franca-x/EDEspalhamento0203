package controller;

import matheus.ListaObject.ListaObject;
import model.Num;

public class TabelaController 
{
	
	private ListaObject[] listaAntiga;
	private ListaObject[] listaNova;
	
	public TabelaController()
	{
		listaAntiga = new ListaObject[10];
		listaNova = new ListaObject[5];
		
		iniciaLista();
	}
	
	public void iniciaLista()
	{
		int tam = listaAntiga.length;
		
		for (int i = 0; i < tam; i++)
		{
			listaAntiga[i] = new ListaObject();
			if (i >= 5)
			{
				listaNova[i - 5] = new ListaObject();
			}
		}
	}
	
	public void iniciaListaAntiga(int[][] vet) throws Exception
	{
		int tam = vet.length;
		
		for (int i = 0; i < tam; i++)
		{
			int tamVet = vet[i].length;
			for (int j = 0; j < tamVet; j++)
			{
				Num numero = new Num(vet[i][j]);
				
				if(listaAntiga[i].isEmpty())
				{
					listaAntiga[i].addFirst(numero);					
				}
				else
				{
					listaAntiga[i].addLast(numero);
				}
			}
		}
	}
	
	public void iniciaListaNova() throws Exception
	{
		int tam = listaAntiga.length;
		
		for (int i = 0; i < tam; i++)
		{
			int tamList = listaAntiga[i].size();
			
			for (int j = 0; j < tamList; j++)
			{
				Num numero = (Num) listaAntiga[i].get(j);
				
				if (listaNova[hashCode(i)].isEmpty())
				{
					listaNova[hashCode(i)].addFirst(numero);					
				}
				else
				{
					listaNova[hashCode(i)].addLast(numero);										
				}
			}
		}
	}
	
	public int hashCode(int i)
	{
		int posit = i / 2;
		return posit;
	}
	
}
