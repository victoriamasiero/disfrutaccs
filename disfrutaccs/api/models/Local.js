


module.exports = {
  connection: 'mysql',
    attributes: {
    id_local: {
    type: 'integer',
    unique: true,
    autoIncrement: true
    },
    Nombre: {
      type: 'string',
      size:100,
      required: true
    },
    Edad_minima: {
      type: 'integer'
    },
    Latitud: {
      type: 'float'
    },
    Longitud: {
      type: 'float'
    },
    Direccion: {
      type: 'string', 
      size:200
    },
    Nro_reseñas: {
      type: 'float'
    },
    Puntaje: {
      type: 'float'
    },
    Preciobase: {
      type: 'float'
    },
    Telefono: {
      type: 'string',
      size:45,
    },
    Tipodelocal: {
      type: 'string'
    },
    descripcion: {
      type: 'string'
    },
    owner: {
    model:'Usuario'
    //required: true
    },
    
    Resenas: {
      collection: 'Resena',
      via:'idlocal'
    }
    
  }
};
