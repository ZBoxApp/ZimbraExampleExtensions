# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://atlas.hashicorp.com/search.
  config.vm.box = "bento/centos-7.3"
  config.ssh.insert_key = false

  config.vm.provision "ansible" do |ansible|
    ansible.playbook = 'vagrant/provision/playbook.yml'
    ansible.sudo = true
  end

  config.vm.network 'private_network', ip: '192.168.50.11'
  config.vm.hostname = 'zimbra.zboxapp.dev'
  config.vm.network 'forwarded_port', guest: 7071, host: 7071
  config.vm.network 'forwarded_port', guest: 7443, host: 7443
  config.vm.network 'forwarded_port', guest: 7080, host: 7080


  config.vm.provider 'virtualbox' do |v|
    v.name = 'zimbra-development'
    v.memory = 2048
    v.cpus = 2
  end

  config.vm.provider 'parallels' do |v|
    v.update_guest_tools = true
    v.name = 'zimbra-development'
    v.memory = 2048
    v.cpus = 2
  end
end
