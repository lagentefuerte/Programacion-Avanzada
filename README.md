# Programación Avanzada – Proyectos en Java ☕️💻

Este repositorio contiene ejercicios y proyectos desarrollados en Java como parte de la asignatura **Programación Avanzada** del Grado en Ingeniería de la Ciberseguridad (Universidad Rey Juan Carlos).

Incluye la resolución del segundo examen parcial (enero 2023) y una implementación funcional del juego **Solitario**.

## 📁 Estructura del proyecto

├── README.md

│

├── Parcial2/ # Ejercicio resuelto del segundo parcial

│ ├── PACiber_PartePracticaEnero2023.pdf - Enunciado oficial del examen

│ └── src/ - Código fuente Java

│ ├── Gestor.java

│ ├── JuegoInfantil.java

│ ├── TipoEvento.java

│ │

│ ├── Espacios/ # Jerarquía de clases para tipos de espacios

│ │ ├── EspacioCelebracionesInfantiles.java

│ │ ├── EspacioEvento.java

│ │ ├── Loft.java

│ │ └── NaveChic.java

│ │

│ ├── Exceptions/ # Excepciones personalizadas

│ │ ├── NoValidDateException.java

│ │ └── NoValidNameException.java

│ │

│ └── Utils/ # Utilidades y calendario

│ ├── CalendarioAnual.java

│ └── Utils.java

│

└── Solitario/ # Implementación del juego Solitario

├── Main.java - Punto de entrada del programa

└── Solitario/

├── Solitario.java - Lógica principal del juego

│

├── Cartas/ # Modelado de cartas

│ ├── Carta.java

│ ├── Palos.java

│ └── Valores.java

│

└── Pilas/ # Estructuras de pilas del juego

├── PilaCartas.java

├── PilaCartasInferior.java

└── PilaCartasSuperior.java


---

## 🧪 Parcial 2 – Examen Resuelto

En la carpeta `Parcial2` se incluye la **resolución del segundo examen parcial (enero 2023)** de la asignatura, con el enunciado original (`.pdf`) y una implementación completa y funcional del sistema propuesto. Se trata de una simulación de espacios para eventos infantiles, que aplica:

- Herencia y polimorfismo
- Excepciones personalizadas
- Gestión de fechas y validaciones
- Principios de diseño orientado a objetos

## 🃏 Solitario en Java

En la carpeta `Solitario` se encuentra una implementación completa del juego **Solitario** en consola. Este proyecto destaca por:

- Uso de enumeraciones (`enum`) para modelar palos y valores
- Diseño modular con clases para cartas, pilas y lógica de juego
- Manipulación de estructuras de datos
- Organización en paquetes (`Cartas`, `Pilas`, etc.)

## 🧰 Tecnologías

- Java 17+
- Uso de paquetes, excepciones, y estructuras personalizadas
- Proyecto ejecutable desde consola o IDE (NetBeans, IntelliJ, Eclipse)

---

## 📚 Créditos

Autor: **Martín Díaz-Benito**  
Asignatura: *Programación Avanzada*  
Universidad Rey Juan Carlos – 2025


