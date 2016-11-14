module.exports = {
  connection: 'mysql',
    attributes: {
    id_a: {
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
    Nro_reseñas: {
      type: 'float'
    },
    Puntaje: {
      type: 'float'
    },
    Preciobase: {
      type: 'float'
    },
    Tipodelocal: {
      type: 'string'
    },
    Descripcion: {
      type: 'text'
    },
    Local: {
      type: 'boolean'
    },
    owner: {
    model:'Usuario'
    //required: true
    },
    Resenas: {
      collection: 'Resena',
      via:'idactividad'
    } 
  }
};
