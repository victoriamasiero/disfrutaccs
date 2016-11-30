module.exports = {
  connection: 'mysql',
    attributes: {
    Nombre: {
      type: 'string',
      size:100,
      required: true,
      unique:true,
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
    Descripcion: {
      type: 'text'
    },
    Local: {
      type: 'boolean',
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
