﻿using System;

namespace Proyecto1
{
    class Program
    {
        static int numero;
        double numDecimal;
        bool condicional;
        char letra;
        string cadena;

        static void Ejercicio1()
        {
            int a = 5, b = 5;
            if(a>b)
			{
				Console.WriteLine("A es mayor que B");
			}
			else
			{
				Console.WriteLine("B es mayor o igual que A");
			}
        }

        static void Ejercicio2()
        {
            Console.WriteLine("Introduce una letra");
            var letra = Console.ReadKey(true);
            if (letra.KeyChar >= 'A' && letra.KeyChar <= 'Z')
            {
                Console.WriteLine("La letra es mayúscula");
            }
            else
            {
                Console.WriteLine("La letra no es mayúscula");
            }
        }
        static void Main(string[] args)
        {
            Ejercicio1();
            Ejercicio2();
        }
    }
}
