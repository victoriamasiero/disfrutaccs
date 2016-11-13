/**
 * Dirreccion.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'mysql',
    attributes: {
    id_d: {
    type: 'integer',
    unique: true,
    autoIncrement: true
    },
    Codigo_postal: {
      type: 'integer',
      size:20,
      required: true
    },
    Direccion: {
      type: 'text'
    }
  }
};

