API
La API está diseñada para gestionar una tienda en línea y cubre funcionalidades clave como la administración de usuarios, productos y carritos de compra, así como la creación de facturas. Está construida en Java utilizando Spring Boot y JWT para la autenticación.

Servicios y Endpoints Principales
1. Servicio de Usuarios
Registro y Autenticación: Permite a los usuarios registrarse y autenticarse en la tienda.
Gestión de Perfiles: Administra la información del perfil del usuario.
2. Servicio de Catálogo de Productos
Obtener Productos:
GET /product/all: Lista todos los productos.
GET /product/name/{name}: Busca un producto por nombre.
GET /product/category/{category}: Busca productos por categoría.
3. Servicio de Carrito de Compras
Añadir Ítem al Carrito:
POST /cart/add: Añade un ítem al carrito.
Eliminar Ítem del Carrito:
DELETE /cart/remove: Elimina un ítem del carrito.
Eliminar Carrito:
DELETE /cart/delete/{cartId}: Elimina el carrito.
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
