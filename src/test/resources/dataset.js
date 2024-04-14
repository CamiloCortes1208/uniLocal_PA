db = connect( 'mongodb://root:example@localhost:27017/proyecto?authSource=admin' );

db.moderadores.insertMany([
    {

    }
]);

db.clientes.insertMany([
    {
        _id: 'Cliente1',
        nickname: 'juanito',
        ciudadResidencia: 'Armenia',
        fotoPerfil: 'mi foto',
        email: 'juan@email.com',
        password: 'mipassword',
        nombre: 'Juan',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente2',
        nickname: 'pablo',
        ciudadResidencia: 'Pereira',
        fotoPerfil: 'mi foto',
        email: 'pablo@email.com',
        password: 'mipassword',
        nombre: 'Pablo',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente3',
        nickname: 'sofía',
        ciudadResidencia: 'Bogotá',
        fotoPerfil: 'mi foto',
        email: 'sofia@email.com',
        password: 'mipassword',
        nombre: 'Guillermo',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente4',
        nickname: 'alejandro',
        ciudadResidencia: 'Armenia',
        fotoPerfil: 'mi foto',
        email: 'alejandro@email.com',
        password: 'mipassword',
        nombre: 'Alejandro',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    },
    {
        _id: 'Cliente5',
        nickname: 'laura',
        ciudadResidencia: 'Cali',
        fotoPerfil: 'mi foto',
        email: 'laura@email.com',
        password: 'mipassword',
        nombre: 'Laura',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Cliente'
    }
]);

db.negocios.insertMany([
    {
        _id: 'Negocio1',
        nombre: 'Restaurante Mexicano',
        descripcion: 'Restaurante de comida mexicana en Armenia',
        codigoCliente: 'Cliente1',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        listaRutasImagenes: ['imagen1', 'imagen2'],
        categoriaNegocio: 'RESTAURANTE',
        listaHorarios: [
            {
                diaSemana: 'LUNES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            }
        ],
        listaTelefonos: ['1234567', '7654321'],
        estadoRegistro: 'ACTIVO',
        estadoNegocio: 'PENDIENTE',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    }
]);

db.calificaciones.insertMany([
    {
        mensaje: "Excelente sitio, muy buena atención",
        fecha: new Date(),
        codigoCliente: 'Cliente1',
        codigoNegocio: 'Negocio1',
        calificacion: 5,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Comentario'
    }
]);

db.revisiones.insertMany([
    {

    }
]);

db.publicaciones.insertMany([
    {

    }
]);

db.opiniones.insertMany([
    {

    }
]);

db.eventos.insertMany([
    {

    }
]);
