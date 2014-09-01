SELECT
     pedidosview.`fecha_pedido` AS Fecha,
     pedidosview.`apellidonombre` AS Cliente,
     pedidosview.`DIRECCION` AS Direccion,
     pedidosview.`nombre` AS Articulo,
     pedidosview.`cantidad` AS Cantidad,
     pedidosview.`movilasignado` AS Movil,
     pedidosview.`flete` AS Flete,
     pedidosview.`total` AS Total
FROM
     `pedidosview` pedidosview