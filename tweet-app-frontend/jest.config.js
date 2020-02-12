const {defaults} = require('jest-config');

module.exports = {
    verbose: true,
    "setupFilesAfterEnv": ["./setupTests.js"],
    moduleFileExtensions: [
        ...defaults.moduleFileExtensions,
        'ts',
        'tsx',
        'js'
    ],
    coveragePathIgnorePatterns: ["/node_modules/", "node"]
};