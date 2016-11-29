/**
 * Categoria.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
 connection: 'mysql',
  attributes: {
    Nombre: {
      type: 'string',
      size:45,
      required: true
    }
  }
};

