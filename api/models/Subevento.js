/**
 * Subevento.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
 //connection: 'PostgresqlServer',
     attributes: {
    Nombre: {
      type: 'string',
      size:100,
      required: true
    },
     Categoria: {
      type: 'string',
      notNull:true
    },
    Descripcion: {
      type: 'text',
      notNull:true,
      required:true
    },
     Fecha_inicio: {
      type: 'date'
    },
    Fecha_fin: {
      type: 'date'
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
      type: 'float',
      notNull:true
    }
  }
};

