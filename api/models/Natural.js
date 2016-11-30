/**
 * Dirreccion.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'PostgresqlServer',
  attributes: {
    Sexo: {
      type: 'string',
      size:10
    },
    Puntos: {
      type: 'float'
    },
    Codigo_postal: {
      type: 'float',
      size:20
    },
    Presupuesto: {
      type: 'float'
    },
    idusuario:{
      model:'Usuario',
      required: true
    }
  }
};

