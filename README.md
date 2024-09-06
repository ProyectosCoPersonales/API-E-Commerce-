API
La API está diseñada para gestionar una tienda en línea y cubre funcionalidades clave como la administración de usuarios, productos y carritos de compra, así como la creación de facturas. Está construida en Java utilizando Spring Boot y JWT para la autenticación.

Servicios y Endpoints Principales
1. Servicio de Usuarios
Registro y Autenticación: Permite a los usuarios registrarse y autenticarse en la tienda.
Gestión de Perfiles: Administra la información del perfil del usuario.
![image](https://github.com/user-attachments/assets/feb14e7c-e874-4924-b061-45c83141a3c8)
![image](https://github.com/user-attachments/assets/1bcb9214-07d0-4edc-99bb-77b8b512eabf)
2. Servicio de Catálogo de Productos
Obtener Productos:
GET /product/all: Lista todos los productos.
GET /product/name/{name}: Busca un producto por nombre.
GET /product/category/{category}: Busca productos por categoría.

![image](https://github.com/user-attachments/assets/8a2e6a90-c369-4a67-840a-6ba6f7a6f7e1)
![image](https://github.com/user-attachments/assets/a9bde14b-e1fc-4a19-b790-bf06aa8f4ef1)
![image](https://github.com/user-attachments/assets/64507fd4-9023-4566-a606-2c63af41cbcf)

3. Servicio de Carrito de Compras
Añadir Ítem al Carrito:
POST /cart/add: Añade un ítem al carrito.
Eliminar Ítem del Carrito:
DELETE /cart/remove: Elimina un ítem del carrito.
Eliminar Carrito:
DELETE /cart/delete/{cartId}: Elimina el carrito.
![image](https://github.com/user-attachments/assets/0cc59116-4fd7-4a31-aa21-9d57c8800255)
![image](https://github.com/user-attachments/assets/3fdbf757-ad61-4b73-9a3d-5623f099a8c5)
![image](https://github.com/user-attachments/assets/444f6cec-24ce-45a0-af24-5fe72a202b30)

4. Servicio de Administración (Administrador)
Gestión de Productos y Usuarios:
POST /admin/products: Crea un nuevo producto.
DELETE /admin/products/{productId}: Elimina un producto.
DELETE /admin/users/{userId}: Elimina un usuario.
Promoción de Usuarios:
POST /admin/promote/{userId}: Promueve un usuario a administrador.
5. API de Facturación
Crear Factura:
POST /api/invoices/create: Genera una factura para un usuario, incluyendo información del carrito de compras.
Modelos y Estructuras
User: Información del usuario.
Product: Información del producto.
Cart: Información del carrito, incluyendo ítems.
Invoice: Información de la factura, asociada a un usuario y carrito.

![image](https://github.com/user-attachments/assets/29d07ee1-7fac-4b01-9d0a-0bd6451eb293)




