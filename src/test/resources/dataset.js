db = connect( 'mongodb://root:example@localhost:27017/proyecto?authSource=admin' );

db.moderadores.insertMany([
    {
        _id: 'Moderador1',
        nombre: 'Jhon',
        fotoPerfil: 'mi foto',
        password: 'mipassword',
        email: 'jhon@email.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador2',
        nombre: 'Paula',
        fotoPerfil: 'mi foto',
        password: 'mipassword',
        email: 'paula@email.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador3',
        nombre: 'Mariana',
        fotoPerfil: 'mi foto',
        password: 'mipassword',
        email: 'mariana@email.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador4',
        nombre: 'Maicol',
        fotoPerfil: 'mi foto',
        password: 'mipassword',
        email: 'maicol@email.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
    },
    {
        _id: 'Moderador5',
        nombre: 'Luis',
        fotoPerfil: 'mi foto',
        password: 'mipassword',
        email: 'luis@email.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Moderador'
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
    },
    {
        _id: 'Negocio2',
        nombre: 'Mundo Computo',
        descripcion: 'Tienda de computadores y servicio técnico',
        codigoCliente: 'Cliente2',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        listaRutasImagenes: ['imagen1', 'imagen2'],
        categoriaNegocio: 'TIENDA_TECNOLOGICA',
        listaHorarios: [
            {
                diaSemana: 'LUNES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'MARTES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            }
        ],
        listaTelefonos: ['1234567'],
        estadoRegistro: 'ACTIVO',
        estadoNegocio: 'PENDIENTE',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    },
    {
        _id: 'Negocio3',
        nombre: 'El palacio',
        descripcion: 'Hotel lujoso en Pereira',
        codigoCliente: 'Cliente1',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        listaRutasImagenes: ['imagen1', 'imagen2'],
        categoriaNegocio: 'HOTEL',
        listaHorarios: [
            {
                diaSemana: 'LUNES',
                horaApertura: '06:00',
                horaCierre: '22:00'
            },
            {
                diaSemana: 'MARTES',
                horaApertura: '06:00',
                horaCierre: '22:00'
            },
            {
                diaSemana: 'MIERCOLES',
                horaApertura: '06:00',
                horaCierre: '22:00'
            },
            {
                diaSemana: 'JUEVES',
                horaApertura: '06:00',
                horaCierre: '22:00'
            },
            {
                diaSemana: 'VIERNES',
                horaApertura: '06:00',
                horaCierre: '22:00'
            },
            {
                diaSemana: 'SABADO',
                horaApertura: '06:00',
                horaCierre: '22:00'
            },
            {
                diaSemana: 'DOMINGO',
                horaApertura: '06:00',
                horaCierre: '22:00'
            },
        ],
        listaTelefonos: ['1234567', '7654321', '7483121'],
        estadoRegistro: 'ACTIVO',
        estadoNegocio: 'PENDIENTE',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    },
    {
        _id: 'Negocio4',
        nombre: 'Adrenaline center',
        descripcion: 'Tienda de artículos deportivos en Medellín',
        codigoCliente: 'Cliente4',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        listaRutasImagenes: ['imagen1', 'imagen2'],
        categoriaNegocio: 'TIENDA_DEPORTIVA',
        listaHorarios: [
            {
                diaSemana: 'LUNES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'MARTES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'MIERCOLES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'JUEVES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'VIERNES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            }
        ],
        listaTelefonos: ['1234567', '7654321'],
        estadoRegistro: 'ACTIVO',
        estadoNegocio: 'PENDIENTE',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    },
    {
        _id: 'Negocio5',
        nombre: 'Museo pequeña Grecia',
        descripcion: 'Centro cultural de historias y esculturas griegas',
        codigoCliente: 'Cliente5',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        listaRutasImagenes: ['imagen1', 'imagen2'],
        categoriaNegocio: 'MUSEO',
        listaHorarios: [
            {
                diaSemana: 'LUNES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'MIERCOLES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'JUEVES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'VIERNES',
                horaApertura: '08:00',
                horaCierre: '20:00'
            },
            {
                diaSemana: 'SABADO',
                horaApertura: '08:00',
                horaCierre: '20:00'
            }
        ],
        listaTelefonos: ['7654321'],
        estadoRegistro: 'ACTIVO',
        estadoNegocio: 'PENDIENTE',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Negocio'
    }
]);

db.calificaciones.insertMany([
    {
        _id: 'Calificacion1',
        mensaje: "Excelente sitio, muy buena atención",
        fecha: new Date(),
        codigoCliente: 'Cliente2',
        codigoNegocio: 'Negocio1',
        calificacion: 5,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Comentario'
    },
    {
        _id: 'Calificacion2',
        mensaje: "Se demoran mucho en atender, pero la comida es exquisita",
        fehca: new Date(),
        codigoCliente : 'Cliente3',
        codigoNegocio: 'Negocio1',
        calificacion: 3,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Comentario'
    },
    {
        _id: 'Calificacion3',
        mensaje: "Gran tienda, se encuentra cualquier cosa que se necesite",
        fehca: new Date(),
        codigoCliente : 'Cliente3',
        codigoNegocio: 'Negocio2',
        calificacion: 5,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Comentario'
    },
    {
        _id: 'Calificacion3',
        mensaje: "Pésima atención, y precios excesivos pare la calidad de las habitaciones",
        fehca: new Date(),
        codigoCliente : 'Cliente4',
        codigoNegocio: 'Negocio3',
        calificacion: 1,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Comentario'
    },
    {
        _id: 'Calificacion4',
        mensaje: "Excelentes precios y atención, pero faltan artículos como raquetas",
        fehca: new Date(),
        codigoCliente : 'Cliente1',
        codigoNegocio: 'Negocio4',
        calificacion: 3,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Comentario'
    },
    {
        _id: 'Calificacion5',
        mensaje: "Muy buen lugar, bastante informativo",
        fehca: new Date(),
        codigoCliente : 'Cliente1',
        codigoNegocio: 'Negocio5',
        calificacion: 4,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Comentario'
    }
]);

db.revisiones.insertMany([
    {
        _id: 'Revision1',
        fecha: new Date(),
        codigoModerador: 'Moderador1',
        codigoNegocio: 'Negocio1',
        descripcion: "El negocio cumple con las normas de la página",
        estadoNegocio: 'APROBADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    },
    {
        _id: 'Revision2',
        fecha: new Date(),
        codigoModerador: 'Moderador2',
        codigoNegocio: 'Negocio2',
        descripcion: "El negocio cumple con las normas de la página",
        estadoNegocio: 'APROBADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    },
    {
        _id: 'Revision3',
        fecha: new Date(),
        codigoModerador: 'Moderador1',
        codigoNegocio: 'Negocio3',
        descripcion: "Las fotos proporcionadas para este negocio incumplen las normas" +
            "de la página",
        estadoNegocio: 'RECHAZADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    },
    {
        _id: 'Revision4',
        fecha: new Date(),
        codigoModerador: 'Moderador3',
        codigoNegocio: 'Negocio4',
        descripcion: "El negocio cumple con las normas de la página",
        estadoNegocio: 'APROBADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    },
    {
        _id: 'Revision5',
        fecha: new Date(),
        codigoModerador: 'Moderador5',
        codigoNegocio: 'Negocio5',
        descripcion: "La descripción proporcionada para este negocio incumple" +
            " con las normas de la página",
        estadoNegocio: 'RECHAZADO',
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Revision'
    }

]);

db.publicaciones.insertMany([
    {
        _id: 'Publicacion1',
        fecha: new Date(),
        codigoCliente: 'Cliente1',
        descripcion: "Ven y conoce el mejor restaurante de Armenia",
        cantidadMeGusta: 20,
        listaRutasImagenes: ['imagen1','imagen2'],
        listaOpiniones: ['Opinion1','Opinion2'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion2',
        fecha: new Date(),
        codigoCliente: 'Cliente2',
        descripcion: "El mejor lugar para comprar un PC es aquí ;)",
        cantidadMeGusta: 32,
        listaRutasImagenes: ['imagen1','imagen2'],
        listaOpiniones: ['Opinion3'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion3',
        fecha: new Date(),
        codigoCliente: 'Cliente1',
        descripcion: "Aquí explorando la historia griega",
        cantidadMeGusta: 20,
        listaRutasImagenes: ['imagen1'],
        listaOpiniones: ['Opinion4'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion4',
        fecha: new Date(),
        codigoCliente: 'Cliente4',
        descripcion: "Disfrutando de mi nuevo computador gracias a Mundo Computo",
        cantidadMeGusta: 8,
        listaRutasImagenes: ['imagen1','imagen2','imagen3','imagen4'],
        listaOpiniones: ['Opinion5'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    },
    {
        _id: 'Publicacion5',
        fecha: new Date(),
        codigoCliente: 'Cliente5',
        descripcion: "La mejor tienda de artículos deportivos",
        cantidadMeGusta: 17,
        listaRutasImagenes: ['imagen1','imagen2'],
        listaOpiniones: ['Opinion6'],
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Publicacion'
    }
]);

db.opiniones.insertMany([
    {
        _id: 'Opinion1',
        fecha: new Date(),
        codigoCliente: 'Cliente2',
        mensaje: 'Puedo confirmar que es un gran restaurante',
        numeroMeGusta: 10,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion2',
        fecha: new Date(),
        codigoCliente: 'Cliente3',
        mensaje: 'La verdad no es tan bueno',
        numeroMeGusta: 4,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion3',
        fecha: new Date(),
        codigoCliente: 'Cliente3',
        mensaje: 'Ahí compré mi primer PC, super recomendado',
        numeroMeGusta: 8,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion4',
        fecha: new Date(),
        codigoCliente: 'Cliente2',
        mensaje: 'Que lugar tan aburrido...',
        numeroMeGusta: 1,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion5',
        fecha: new Date(),
        codigoCliente: 'Cliente1',
        mensaje: 'Hay mejores lugares para comprar',
        numeroMeGusta: 3,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    },
    {
        _id: 'Opinion6',
        fecha: new Date(),
        codigoCliente: 'Cliente3',
        mensaje: 'De lo mejor en deportes, gran lugar',
        numeroMeGusta: 12,
        _class: 'co.edu.uniquindio.uniLocal_PA.modelo.documentos.Opinion'
    }
]);
