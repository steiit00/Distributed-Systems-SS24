# Base image
FROM node:18-alpine

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json (if available)
COPY package*.json ./

# Install dependencies
RUN npm install --legacy-peer-deps

# Copy the rest of the project files
COPY . .

# Build the project
RUN npm run build

# Expose the port
EXPOSE 8080

# Start the server
CMD [ "npm", "run", "serve" ]
