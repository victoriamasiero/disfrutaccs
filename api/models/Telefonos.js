/**
 * Telefonos.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
    connection: 'mysql',
    attributes: {
    Numero_telefono: {
      type: 'integer',
      size:100,
      required: true
    },
    idactividad: {
    model:'Actividad'
    }
  }
};

