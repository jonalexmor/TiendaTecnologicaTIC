var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {

        $("#user-tipo_cliente").html(user.tipo_cliente.toFixed(2) + "$");

        getArticulos(false, "ASC");
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getArticulos(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletArticulosListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarArticulos(parsedResult);
            } else {
                console.log("Error recuperando los datos de los articulos");
            }
        }
    });
}
function mostrarArticulos(articulos) {

    let contenido = "";

    $.each(articulos, function (index, articulo) {

        articulo = JSON.parse(articulo);
        let precio;

        if (articulo.unidades > 0) {

            if (user.tipo_cliente) {

                if (articulo.novedad) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (articulo.novedad) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + articulo.id + '</th>' +
                    '<td>' + articulo.nombre + '</td>' +
                    '<td>' + articulo.categoria + '</td>' +
                    '<td>' + articulo.tipo + '</td>' +
                    '<td>' + articulo.servicio + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + articulo.id + '" disabled ';
            if (articulo.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="alquilarArticulo(' + articulo.id + ',' + precio + ');" class="btn btn-success" ';
            if (user.tipo_cliente < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'

        }
    });
    $("#articulos-tbody").html(contenido);
}



