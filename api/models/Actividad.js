 /*
 * @description :: TODO: Modelo relacionado con las actividades tanto locales como eventos.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

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
    Categoria: {
      type: 'String',
      size:50
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
