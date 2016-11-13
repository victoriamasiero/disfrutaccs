/**
 * Natural.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'mysql',
  attributes: {
    Sexo: {
      type: 'string',
      size:10
    },
    Puntos: {
      type: 'float'
    },
    Codigo_postal: {
      type: 'integer',
      size:20,
      required: true
    },
    Presupuesto: {
      type: 'float',
      notNull:true
    },
    owner:{
      model:'Usuario',
    },
    clave: {
      type: 'string',
      required: true
    }
  }
};

