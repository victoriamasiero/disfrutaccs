/**
 * Telefonos.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
    connection: 'mysql',
    attributes: {
    id_t: {
    type: 'integer',
    required:true
    },
    Numero_telefono: {
      type: 'integer',
      size:100,
      required: true
    }
  }
};

